package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс HelloController является контроллером Spring MVC, который отвечает за обработку HTTP-запросов.
 *
 * Взаимодействие:
 * - Этот контроллер возвращает представление "index" и передает в него данные (список сообщений).
 * - Используется аннотация @Controller, что указывает Spring, что это контроллер, обрабатывающий запросы.
 * - Методы контроллера обрабатывают запросы, используя аннотацию @GetMapping.
 */
@Controller // Аннотация, указывающая, что данный класс является контроллером Spring MVC
public class HelloController {

	/**
	 * Метод обрабатывает GET-запрос по корневому URL ("/").
	 * Создает список сообщений и добавляет их в модель для отображения на странице.
	 *
	 * @param model - объект ModelMap для передачи данных в представление
	 * @return строка "index" - имя представления (JSP или HTML страница), которое будет отображаться
	 */
	@GetMapping(value = "/") // Аннотация для обработки GET-запросов по указанному URL
	public String printWelcome(ModelMap model) {
		// Создаем список сообщений
		List<String> messages = new ArrayList<>();
		messages.add("Hello!"); // Добавляем первое сообщение
		messages.add("I'm Spring MVC application"); // Добавляем второе сообщение
		messages.add("5.2.0 version by sep'19 "); // Добавляем третье сообщение

		// Добавляем список сообщений в модель, чтобы передать их в представление
		model.addAttribute("messages", messages);

		// Возвращаем имя представления "index", которое будет отображено пользователю
		return "index";
	}
}