package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Normal java function
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09003045060"));
        System.out.println(isPhoneNumberValid("0900304506"));

        // Predicate functionaL interface
        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("07003045060"));
        System.out.println(isPhoneNumberValidPredicate.test("0900304506"));

        System.out.println(
                "Is phone number valid and contains 3 = " + isPhoneNumberValidPredicate.and(containsNumber3).test("07000000000")
        );

        System.out.println(
                "Is phone number valid and contains 3 = " + isPhoneNumberValidPredicate.and(containsNumber3).test("07003045060")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
