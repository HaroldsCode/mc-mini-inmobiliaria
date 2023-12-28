package dev.harolds.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        value = "compra-service",
        path = "/api/compra",
        configuration = FeignConfiguration.class
)
public interface ComprasServiceRequest {

    @PostMapping
    Object saveCompra(@RequestBody Object compra);

    @GetMapping("{userId}")
    List<Object> findAllByUserId(@PathVariable Long userId);
}
