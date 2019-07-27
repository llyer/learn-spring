package me.liluyang.jpa.dto;

import org.springframework.beans.factory.annotation.Value;

public interface UserView3 {

    /**
     *
     * 开放式投影，开放式投影。开放式投影可以使用不完全和实体类相同的 getter 和 setter 方法，并且在运行时，动态的返回计算结果。
     *
     * 开放式预测有一个缺点：Spring Data无法优化查询执行，因为它事先不知道将使用哪些属性。
     *
     * 因此，当封闭投影无法满足我们的要求时，我们应该只使用开放投影。
     *
     * 使用 @value 注解查询复合结果，@Value 注解内部的表达式是 spel 表达式。类似前端 Vue 等工具的计算属性
     *
     * target 指真实的实体类对象
     * @return
     */
    @Value("#{target.username + '&' + target.gender}")
    String getUsernameAndGender();
}
