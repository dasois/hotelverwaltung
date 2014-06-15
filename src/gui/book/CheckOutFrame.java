package gui.book;

import app.BookingRoomControlImp;
import app.BookingRoomControlInterface;
import db.entities.BookingRoom;
import db.entities.BookingService;
import gui.AbstractFrame;
import gui.MainFrame.VerwaltungMainFrameView;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

@SuppressWarnings("serial")
public class CheckOutFrame extends AbstractFrame {
    private SelectCustomerFrameView scf;
    private VerwaltungMainFrameView mf;
    private JLabel header;
    private JPanel leftPanel;
    private JLabel customer;
    private JLabel price;
    private JPanel boxdleftPanel;
    private JPanel centerPanel;
    private JTextField userTextField;
    private JTextField priceTextField;
    private JPanel boxdCenterPanel;
    private JButton btnCheckout;

    public CheckOutFrame(SelectCustomerFrameView scf, VerwaltungMainFrameView mf) {
        this.scf = scf;
        this.mf = mf;

    }

    @Override
    protected void createWidget() {
        header = new JLabel("Kundenbuchung");
        header.setPreferredSize(new Dimension(400, 40));
        header.setForeground(Color.WHITE);
        header.setBackground(Color.BLACK);
        header.setOpaque(true);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC, 30));

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2, 1, 10, 10));

        customer = new JLabel("Kunde :");
        customer.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC, 20));

        price = new JLabel("Gesamtpreis ");
        price.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC, 20));
        boxdleftPanel = new JPanel();
        boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel, BoxLayout.PAGE_AXIS));

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));

        userTextField = new JTextField(scf.getSelectedCustomer().toString());
        userTextField.setEnabled(false);
        BookingRoomControlInterface face = new BookingRoomControlImp();
        Vector<BookingRoom> tmp;
        try {
            tmp = face.getAllFromCustomer(scf.getSelectedCustomer().getCid());
            double priceSum = 0;
            for (BookingRoom r : tmp) {
                Vector<BookingService> services = face.getRelatedServiceBookings(r.getBrid());
                for (BookingService s : services) {
                    priceSum = priceSum + s.getService().getPrice();
                }
                priceSum = priceSum + r.getRoom().getPrice();

            }
            priceTextField = new JTextField("" + priceSum);
            priceTextField.setEnabled(false);
            priceTextField.setFont(header.getFont().deriveFont(Font.BOLD, 20));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        boxdCenterPanel = new JPanel();
        boxdCenterPanel.setLayout(new BoxLayout(boxdCenterPanel, BoxLayout.PAGE_AXIS));
        btnCheckout = new JButton("Checkout");
        btnCheckout.setPreferredSize(new Dimension(20, 30));
        btnCheckout.setActionCommand("checkout");

    }

    @Override
    protected void addWidget() {
        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(BorderLayout.NORTH, header);
        getContentPane().add(BorderLayout.SOUTH, btnCheckout);
        leftPanel.add(customer);
        leftPanel.add(price);
        boxdleftPanel.add(leftPanel);
        boxdleftPanel.add(Box.createVerticalGlue());
        getContentPane().add(BorderLayout.WEST, boxdleftPanel);

        centerPanel.add(userTextField);
        centerPanel.add(priceTextField);
        boxdCenterPanel.add(centerPanel);
        boxdCenterPanel.add(Box.createVerticalGlue());
        getContentPane().add(BorderLayout.CENTER, boxdCenterPanel);
        System.out.println("happends");

    }

    @Override
    protected void setupInteractions() {

    }
}