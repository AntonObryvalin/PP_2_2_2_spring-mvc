package web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * Класс WebConfig является конфигурационным классом Spring MVC для настройки шаблонизатора и обработки представлений.
 * Используется для настройки Thymeleaf как движка для отображения страниц в приложении.
 *
 * Взаимодействие:
 * - Этот класс сканирует компоненты в пакете "web" с помощью аннотации @ComponentScan.
 * - Управляет шаблонизатором Thymeleaf для отображения HTML-страниц.
 * - Связан с DispatcherServlet через класс `AppInit`, который указывает на этот конфигурационный класс.
 */
@Configuration // Аннотация, указывающая, что этот класс является конфигурацией Spring
@EnableWebMvc   // Включает поддержку Spring MVC
@ComponentScan("web") // Сканирует пакет "web" для поиска компонентов, контроллеров и других бинов
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    // Конструктор, через который Spring передает ApplicationContext в этот конфигурационный класс
    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Бин для настройки Thymeleaf шаблонизатора.
     * Устанавливает путь к шаблонам и их расширение.
     *
     * @return SpringResourceTemplateResolver - конфигуратор шаблонов
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext); // Устанавливаем ApplicationContext
        templateResolver.setPrefix("/WEB-INF/pages/"); // Префикс, где находятся страницы
        templateResolver.setSuffix(".html"); // Расширение файлов, которое будет использоваться для шаблонов
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    /**
     * Бин для настройки движка Thymeleaf.
     * Включает компиляцию Spring Expression Language (SpEL) для Thymeleaf.
     *
     * @return SpringTemplateEngine - движок Thymeleaf
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver()); // Устанавливаем резолвер шаблонов
        templateEngine.setEnableSpringELCompiler(true); // Включаем поддержку Spring EL для динамического контента
        return templateEngine;
    }

    /**
     * Настройка резолвера представлений.
     * Устанавливаем ThymeleafViewResolver для разрешения HTML-страниц.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine()); // Устанавливаем движок Thymeleaf для резолвера
        registry.viewResolver(resolver); // Регистрируем ThymeleafViewResolver в Spring MVC
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8");
    }
}