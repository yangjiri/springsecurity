package io.security.corespringsecurity.controller.user;


import io.security.corespringsecurity.domain.Account;
import io.security.corespringsecurity.domain.AccountDto;
import io.security.corespringsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/mypage")
    public String myPage() throws Exception{
        return "user/mypage";
    }

    // 会員登録ページ
    @GetMapping("/users")
    public String createUser(){
        return "user/login/register";
    }

    // 会員登録時にDBに保存
    @GetMapping("/users")
    public String createUser(AccountDto accountDto){

        ModelMapper modelMapper = new ModelMapper();
        // accountDtoのデータをaccountEntityに移す(マッピング)
        Account account = modelMapper.map(accountDto, Account.class);
        // passwordは暗号化
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return "redirect:/";
    }

}
