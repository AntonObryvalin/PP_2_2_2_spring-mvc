package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс AppInit инициализирует конфигурацию сервлета для Spring MVC приложения.
 * Этот класс наследует AbstractAnnotationConfigDispatcherServletInitializer,
 * чтобы автоматически зарегистрировать DispatcherServlet и добавить необходимые конфигурации.
 *
 * Взаимодействие:
 * - Связан с классом конфигурации `WebConfig`, который содержит настройки для отображения представлений (ViewResolver).
 * - Задает корневую точку для всех запросов через метод `getServletMappings()`.
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на корневую конфигурацию приложения. Возвращает null, так как в данном случае корневая конфигурация не используется.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Метод возвращает классы конфигурации, включая WebConfig, который настраивает ViewResolver для отображения JSP-страниц.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class // Указываем, что конфигурация для отображения представлений находится в классе WebConfig.
        };
    }

    /*
     * Метод getServletMappings() задает URL-маршрут, на котором будет базироваться приложение.
     * В данном случае указывается "/", что означает, что все запросы будут направляться через DispatcherServlet.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}