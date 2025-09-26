package com.infnet.victorapiparttwo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ApplicationMainTest {

    @Test
    @DisplayName("Application main should not throw when started with no web server and banner off")
    void runMainDoesNotThrow() {
        assertDoesNotThrow(() -> VictorapiparttwoApplication.main(new String[]{"--spring.main.banner-mode=off", "--spring.main.web-application-type=none"}));
    }
}
