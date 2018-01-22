package org.autumn.uua.captcha;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.autumn.commons.utils.ResultUtil;
import org.autumn.uua.captcha.enums.CaptchaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 授权验证码的过滤器
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 验证码校验失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 系统中的校验码处理器
     */
    @Autowired
    private CaptchaProcessorProvice captchaProcessorProvice;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 存放所有需要校验验证码的URL
     */
    private Map<String, CaptchaType> urlMap = new HashMap<>();

    /**
     * 验证请求URL与配置的URL是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 初始化要拦截的URL配置信息
     *
     * @throws ServletException
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        urlMap.put("/uua", CaptchaType.IMAGE);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        CaptchaType type = getCaptchaType(request);
        if (type != null) {
            logger.info("校验请求[" + request.getRequestURI() + "]中的验证码，验证码类型为" + type);
            try {
                captchaProcessorProvice.findCaptchaProcessor(type).validate(new ServletWebRequest(request, response));
            } catch (CaptchaException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            } catch (Exception e) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(objectMapper.writeValueAsString(ResultUtil.error(e.getMessage())));
                return;
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 获取校验码的类型
     *
     * @param request 请求
     * @return 如果当前请求不需要校验，则返回null
     */
    private CaptchaType getCaptchaType(HttpServletRequest request) {
        CaptchaType type = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) { // 拦截非GET请求
            Set<String> urls = urlMap.keySet();
            for (String url : urls) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    type = urlMap.get(url);
                }
            }
        }
        return type;
    }
}
