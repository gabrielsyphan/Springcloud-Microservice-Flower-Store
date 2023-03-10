package com.syphan.springcloudmicroserviceflowermarket.domain.client;

import com.syphan.springcloudmicroserviceflowermarket.domain.dto.OrderDto;
import com.syphan.springcloudmicroserviceflowermarket.domain.dto.ProviderDto;
import com.syphan.springcloudmicroserviceflowermarket.domain.dto.ProviderOrderInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "provider")
public interface ProviderClient {

    // Feign is connected with Eureka and Ribbon, thus it can find the provider endpoint

    @RequestMapping("/provider/{state}")
    List<ProviderDto> getProviderInfo(@PathVariable String state);

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    ProviderOrderInfoDto createOrder(OrderDto order);
}
