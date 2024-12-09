package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samylle.api.shopping.shopping_api.models.Shop;
import com.samylle.api.shopping.shopping_api.services.ShopService;

@RestController
@RequestMapping("/shopping")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<Shop> getAll() {
        return shopService.getAll();
    }

    @GetMapping("/{id}")
    public Shop findById(@PathVariable String id) {
        return shopService.findById(id);
    }

    @PostMapping
    public Shop save(@RequestBody Shop shop) {
        return shopService.save(shop);
    }

    @GetMapping("/shopByUser")
    public List<Shop> getByUser(@RequestParam String userIdentifier) {
        return shopService.getByUser(userIdentifier);
    }

    @GetMapping("/shopByDate")
    public List<Shop> getByDate(@RequestParam Date startDate, @RequestParam Date endDate) {
        return shopService.getByDate(startDate, endDate);
    }

    @GetMapping("/{productIdentifier}")
    public List<Shop> findByProductIdentifier(@PathVariable String productIdentifier) {
        return shopService.findByProductIdentifier(productIdentifier);
    }

    @GetMapping("/search")
    public List<Shop> getShopsByFilter(
        @RequestParam Date startDate,
        @RequestParam Date endDate,
        @RequestParam double minValue
    ) {
        return shopService.getShopsByFilter(startDate, endDate, minValue);
    }

    @GetMapping("/report")
    public List<Shop> getReportByDate(
        @RequestParam Date startDate,
        @RequestParam Date endDate
    ) {
        return shopService.getReportByDate(startDate, endDate);
    }
}
