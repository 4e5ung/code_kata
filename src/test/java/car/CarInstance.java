package car;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 에너테이션을 사용한 코드가 해당 애너테이션의 정보를 런타임에도 유지해야한다.
@Target(ElementType.METHOD) //이 애너테이션은 메소드에 사용할 수 있다.
@Tag("fast")
@Test
public @interface CarInstance {
}
