package com.syphan.springcloudmicroserviceflowermarket.client;

import com.syphan.springcloudmicroserviceflowermarket.model.Item;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderDto;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderOrderInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "provider")
public interface ProviderClient {

    // Feign is connected with Eureka and Ribbon, thus it can find the provider endpoint

    @RequestMapping("/info/{state}")
    ProviderDto getProviderInfo(@PathVariable String state);

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    ProviderOrderInfoDto createOrder(List<Item> items);
}
