package org.example.password;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is
        // 직접 구현체 객체를 생성 (강한 결합, 다른 패키지에 존재하는 클래스일 경우 import 가 추가됨 )
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be
        // PasswordGenerator 인터페이스를 이용한 방식
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 7자 이상 12자 이하여야 한다.
         */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
