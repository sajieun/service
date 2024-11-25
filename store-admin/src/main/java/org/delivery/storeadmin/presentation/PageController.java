package org.delivery.storeadmin.presentation;

import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping("main")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("main");

        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserSession userSession = (UserSession) authentication.getPrincipal(); // UserSession으로 캐스팅

            // 사용자 정보를 모델에 추가
            modelAndView.addObject("userId", userSession.getUserId());
            modelAndView.addObject("email", userSession.getEmail());
            modelAndView.addObject("storeName", userSession.getStoreName());
            modelAndView.addObject("role",userSession.getRole());

            String authDetails = userSession.toString(); // UserSession의 toString() 메서드 사용
            modelAndView.addObject("authDetails", authDetails);

            // 필요한 다른 정보도 추가 가능
        }

        return modelAndView; // 모델과 뷰 반환

//    @RequestMapping("/order")
//    public ModelAndView order(){
//        return new ModelAndView("order/order");
//    }
}
}