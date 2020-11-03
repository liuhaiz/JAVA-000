package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @author lhz
 * @description 实现过滤器
 * @date 2020/11/3
 */
public class HttpRequestFilterHandler implements HttpRequestFilter  {
	public final static String SOME_PARAM = "nio";

	@Override
	public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		if(null != fullRequest && null!= fullRequest.headers()){
			HttpHeaders httpHeaders = fullRequest.headers();
			httpHeaders.set(SOME_PARAM, "liuhaizhong");
		}
	}
}
