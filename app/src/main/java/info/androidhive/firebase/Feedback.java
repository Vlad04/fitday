package info.androidhive.firebase;

/**
 * Created by papi-vlad on 11/04/17.
 */

public class Feedback {
    int days;
    int injure;
    int tired;
    int next_week;

    boolean b_days = false;
    boolean b_injure = false;
    boolean b_tired = false;
    boolean b_next_week = false;

    int inference_engine() {

        //Rules

        boolean rule_1 = false;
        boolean rule_2 = false;
        boolean rule_3 = false;
        boolean rule_4 = false;

        bool_translate();

        //rule 1
        if (b_days && !b_injure && !b_tired){
            rule_1 = true;
        }

        //rule 2
        if (!b_days && !b_injure && !b_tired && b_next_week){
            rule_2 = true;
        }

        //rule 3
        if (!b_days && !b_injure & b_tired && !b_next_week){
            rule_3 = true;
        }

        //rule 3
        if (b_days && !b_injure && b_tired && !b_next_week){
            rule_4 = true;
        }

        // logical OR of all rules

        if (rule_1 || rule_2 || rule_3 || rule_4 ){
            return 1;
        }

        return 0;
    }

    void  bool_translate(){

        if (days > 3 ) {
            b_days = true;
        }

        if (injure > 0 ) {
            b_injure = true;
        }

        if (tired > 0 ) {
            b_tired = true;
        }

        if (next_week > 0 ) {
            b_next_week = true;
        }

    }
}
