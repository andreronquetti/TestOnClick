package br.com.alrs.teste;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;

public class OnClickDelegate implements android.view.View.OnClickListener {
	private Method method;

	private Object object;

	private Method getMethod() {
		return method;
	}

	private Object getObject() {
		return object;
	}
	
	public static OnClickDelegate delegate(Object object, String nameMethod) {
		return new OnClickDelegate().build(object, nameMethod);
	}

	private OnClickDelegate build(Object object, String nameMethod) {
		if (object == null) {
			throw new IllegalArgumentException("Object have first call");
		}

		for (Method method : object.getClass().getMethods()) {
			if (method.getName().equals(nameMethod)) {
				this.method = method;
				this.object = object;
				break;
			}
		}

		if (this.method == null) {
			throw new IllegalArgumentException(
					"nameMethod no existing in Object");
		}

		return this;
	}

	@Override
	public void onClick(View v) {
		@SuppressWarnings("rawtypes")
		Class[] clazzs = getMethod().getParameterTypes();
		try {
			Object[] objs = null;
			if (clazzs.length == 0) {
				getMethod().invoke(getObject(), objs);
			} else if (clazzs.length == 1 && clazzs[0].equals(View.class)) {
				getMethod().invoke(getObject(), v);
			} else {
				objs = new Object[]{"a1", "a2"};
				getMethod().invoke(getObject(), objs);
			}
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
