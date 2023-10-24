package dev.vepo.mystatistic.views;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@DisplayName("User Views")
public class UserViewsTest {

    @Inject
    UserViews userViews;

    @Test
    void okTest() {
        System.out.println(userViews);
        System.out.println(userViews.viewRepository);
        var results = userViews.register("xxx", "asdadad", "asdadas", 5);
        Assertions.assertThat(results).isNotEmpty().map(view -> view.time).get().isEqualTo(20l);
    }

}
