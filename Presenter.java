package HW7z1;
public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void calculate(String operation, double num1, double num2) {
        try {
            double result = model.calculate(operation, num1, num2);
            view.setResult(result);
        } catch(IllegalArgumentException ex) {
            view.setError(ex.getMessage());
        }
    }
}
