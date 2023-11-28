package sia.tacocloud.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.service.SimpleOrderService;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final SimpleOrderService adminService;

    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
