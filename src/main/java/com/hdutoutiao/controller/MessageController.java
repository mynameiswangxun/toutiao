package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    IMessageService iMessageService;

    @PostMapping("/create")
    public String createMessage(HttpSession httpSession,
                                @RequestParam("toId") Integer toId, @RequestParam("content") String content){
        User user = (User) httpSession.getAttribute("user");
        if(user==null){
            return "no_login";
        }
        Map<String,Object> resMap = iMessageService.createMessage(user.getId(),toId,content);
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "error";
        }
        return "redirect:/message/conversation/detail/"+toId;
    }

    @GetMapping("/conversation")
    public String getConversation(HttpSession httpSession, Model model){
        User user = (User) httpSession.getAttribute("user");
        if(user==null){
            return "no_login";
        }
        Map<String,Object> resMap = iMessageService.getConversationVoList(user.getId());
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "error";
        }
        model.addAttribute("conversationVoList",resMap.get("conversationVoList"));
        return "conversation";
    }

    @GetMapping("/conversation/detail/{otherId}")
    public String getMessages(HttpSession session,Model model,@PathVariable("otherId") Integer otherId){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "no_login";
        }
        Map<String,Object> resMap = iMessageService.getMessageVoList(user.getId(),otherId);
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "error";
        }
        model.addAttribute("messageVoList",resMap.get("messageVoList"));
        model.addAttribute("otherId",otherId);
        return "message_detail";
    }
}
