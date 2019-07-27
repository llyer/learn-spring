package com.liluyang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private static ThreadLocal<Integer> depthLimit = new ThreadLocal<>();

	public static void limitDepth(int max) {
		depthLimit.set(max);
	}

	public static void unLimitDepth() {
		depthLimit.remove();
	}

	private String id;

	private String name;

	private Role role;

	public Role getRole() {

		if (depthLimit.get() == null || 1 < depthLimit.get()) {
			return role;
		} else {
			return null;
		}
	}

}
