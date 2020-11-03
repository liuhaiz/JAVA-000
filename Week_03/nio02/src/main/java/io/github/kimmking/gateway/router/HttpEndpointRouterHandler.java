package io.github.kimmking.gateway.router;

import java.util.List;

/**
 * @author lhz
 * @description 实现路由
 * @date 2020/11/3
 */
public class HttpEndpointRouterHandler implements HttpEndpointRouter{
	@Override
	public String route(List<String> endpoints) {
		if(endpoints.size() > 0 && endpoints.contains("hello")){
			return "/api/hello";
		}
		return "/error";
	}
}
