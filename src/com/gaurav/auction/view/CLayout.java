/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaurav.auction.view;

import java.awt.CardLayout;

/**
 *
 * @author Nishan Dhungana
 */
public class CLayout {
    
    private static CardLayout cardLayout;
    
    public CLayout() {
        cardLayout = new CardLayout();
        Home.jPanel1.setLayout(cardLayout); 
        Home.jPanel1.add(new Login(), "frmLogin");
        Home.jPanel1.add(new Register(), "frmRegister");
        Home.jPanel1.add(new Dashboard(), "dashboard");
        
        //cardLayout.show(jPanel1, "frmLogin");
    }
    
    public static void goToFormLogin() {
        cardLayout.show(Home.jPanel1, "frmLogin");
    }
    
    public static void goToFormRegister() {
        cardLayout.show(Home.jPanel1, "frmRegister");
    }
    
    public static void goToDashboard() {
        Home.jPanel1.removeAll();
        cardLayout.show(Home.jPanel1, "dashboard");
    }
}
