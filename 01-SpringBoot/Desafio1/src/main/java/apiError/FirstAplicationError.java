package apiError;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class FirstAplicationError {

    private String error;

    public FirstAplicationError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
