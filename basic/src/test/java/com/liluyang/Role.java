package com.liluyang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	private static ThreadLocal<Integer> depthLimit = new ThreadLocal<>();

	public static void limitDepth(int max) {
		depthLimit.set(max);
	}

	public static void unLimitDepth() {
		depthLimit.remove();
	}

	private String id;

	private String label;

	private User user;

	public User getUser() {

		if (depthLimit.get() < 1) {
			return user;
		} else {
			return null;
		}
	}

}
