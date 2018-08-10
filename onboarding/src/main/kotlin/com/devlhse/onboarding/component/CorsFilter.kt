package com.devlhse.onboarding.component

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.FilterChain
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.http.HttpServletRequest

@Component
open class CorsFilter : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    public
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token")
        response.addHeader("Access-Control-Expose-Headers", "xsrf-token")
        if ("OPTIONS" == request.getMethod()) {
            response.status = HttpServletResponse.SC_OK
        } else {
            filterChain.doFilter(request, response)
        }
    }
}