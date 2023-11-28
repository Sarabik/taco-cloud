package sia.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.model.TacoOrder;
import sia.tacocloud.model.User;
import sia.tacocloud.repository.UserRepository;
import sia.tacocloud.service.OrderService;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final UserRepository userRepository;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        order.setUser(user);
        if (errors.hasErrors()) {
            return "orderForm";
        }
        orderService.save(order);
        log.info("Order saved: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
