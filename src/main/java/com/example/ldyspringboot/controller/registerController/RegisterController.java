package com.example.ldyspringboot.controller.registerController;

import com.example.ldyspringboot.controller.registerController.dto.RegisterReqDto;
import com.example.ldyspringboot.service.registerService.RegisterService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
@RequestMapping
public class RegisterController {
    private final Logger logger = LogManager.getLogger();
    private final RegisterService registerService;

    @GetMapping("member/registerForm")
    public String registerForm(){
        return "member/registerForm";
    }

    @PostMapping("member/idCheck")
    @ResponseBody
    public String idChecked(@RequestParam String username){
        logger.info("username 체크중 " + username);
        return registerService.idCheck(username); // 조회 결과 count(*) = 1 or 0 을 리턴함
        // debug <== Total: 1 나오는 이유 : count(*) 이 1 이든 0 이든  결과가 1개 나오기 때문에.
    }

    @PostMapping("member/register")
    public String register(RegisterReqDto registerReqDto){
        logger.info(registerReqDto);

        registerService.memberRegister(registerReqDto.toEntity());

        return "redirect:/home";
    }
}
