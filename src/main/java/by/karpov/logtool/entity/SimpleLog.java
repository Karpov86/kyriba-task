package by.karpov.logtool.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class SimpleLog {

    private LocalDateTime dateTime;
    private String nameUser;
    private String message;

    public static class Builder {

        private final SimpleLog simpleLog;

        public Builder() {
            simpleLog = new SimpleLog();
        }

        public Builder setNameUser(String nameUser) {
            simpleLog.nameUser = nameUser;
            return this;
        }

        public Builder setMessage(String message) {
            simpleLog.message = message;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            simpleLog.dateTime = dateTime;
            return this;
        }

        public SimpleLog build() {
            return simpleLog;
        }
    }
}
