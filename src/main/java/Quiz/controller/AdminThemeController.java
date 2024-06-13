package Quiz.controller;
import Quiz.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/themes")
public class AdminThemeController {

    @Autowired
    private ThemeService themeService;

    @PutMapping("/current")
    public void setCurrentTheme(@RequestParam String theme) {
        themeService.setCurrentTheme(theme);
    }

    @GetMapping("/available")
    public List<String> getAvailableThemes() {
        return themeService.getAvailableThemes();
    }
}
