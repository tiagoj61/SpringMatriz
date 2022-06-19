package tiago.j61.projeto.helper;

import org.springframework.web.bind.annotation.PostMapping;

import tiago.j61.projeto.controller.MatrixController;
import tiago.j61.projeto.dto.MatrixRequestDto;
import tiago.j61.projeto.dto.MatrixReturnDto;

public class ReflectionHelper {

	public static String getPathFromMethod(Class clazz, int methodPosition) {
		return clazz.getMethods()[methodPosition].getAnnotation(PostMapping.class).path()[0];
	}

	public static String getAttributeName(Class clazz, int methodPosition) {
		return clazz.getDeclaredFields()[methodPosition].getName();
	}

}
