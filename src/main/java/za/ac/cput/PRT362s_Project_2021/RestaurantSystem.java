package za.ac.cput.PRT362s_Project_2021;

public class RestaurantSystem {

    public static void main(String[] args) {

        POS_GUI pos = new POS_GUI();
        pos.setTitle("Restaurant Management System");
        pos.pack();
        //pos.setLocationRelativeTo(null);
        pos.setSize(1200, 700);
        pos.setVisible(true);
    }
}
