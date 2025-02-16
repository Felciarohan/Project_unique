package com.PHC.AI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/chat")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public String showAI() {
        return "Chat"; // Ensure you have a "chat.html" file
    }

    @PostMapping("/ask")
    @ResponseBody
    public Map<String, String> askQuestion(@RequestParam("question") String question) {
        if (question == null || question.trim().isEmpty()) {
            return Map.of("error", "Question cannot be empty.");
        }

        try {
            String answer = aiService.getAnswer(question);
            return Map.of("response", answer);
        } catch (Exception e) {
            return Map.of("error", "Failed to fetch AI response: " + e.getMessage());
        }
    }
}
