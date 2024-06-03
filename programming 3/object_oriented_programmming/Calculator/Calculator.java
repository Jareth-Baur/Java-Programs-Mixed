package Calculator;

public class Calculator extends javax.swing.JFrame {

    private double num1 = 0.0;
    private double num2 = 0.0;
    private String operator = null;
    private boolean error = false;

    public Calculator() {
        initComponents();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        decimalButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        backSpace = new javax.swing.JButton();
        multiplyButton = new javax.swing.JButton();
        subtractButton = new javax.swing.JButton();
        divideButton = new javax.swing.JButton();
        equalsButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 153, 153));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(153, 153, 153));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(153, 153, 153));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton9.setForeground(new java.awt.Color(0, 0, 0));
        jButton9.setText("9");
        jButton9.setMaximumSize(new java.awt.Dimension(26, 26));
        jButton9.setMinimumSize(new java.awt.Dimension(26, 26));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton0.setBackground(new java.awt.Color(153, 153, 153));
        jButton0.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton0.setForeground(new java.awt.Color(0, 0, 0));
        jButton0.setText("0");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        decimalButton.setBackground(new java.awt.Color(153, 153, 153));
        decimalButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        decimalButton.setForeground(new java.awt.Color(0, 0, 0));
        decimalButton.setText(".");
        decimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decimalButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(153, 153, 153));
        addButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        addButton.setForeground(new java.awt.Color(0, 0, 0));
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        backSpace.setBackground(new java.awt.Color(153, 153, 153));
        backSpace.setForeground(new java.awt.Color(0, 0, 0));
        backSpace.setText("⌫");
        backSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSpaceActionPerformed(evt);
            }
        });

        multiplyButton.setBackground(new java.awt.Color(153, 153, 153));
        multiplyButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        multiplyButton.setForeground(new java.awt.Color(0, 0, 0));
        multiplyButton.setText("*");
        multiplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplyButtonActionPerformed(evt);
            }
        });

        subtractButton.setBackground(new java.awt.Color(153, 153, 153));
        subtractButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        subtractButton.setForeground(new java.awt.Color(0, 0, 0));
        subtractButton.setText("-");
        subtractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtractButtonActionPerformed(evt);
            }
        });

        divideButton.setBackground(new java.awt.Color(153, 153, 153));
        divideButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        divideButton.setForeground(new java.awt.Color(0, 0, 0));
        divideButton.setText("÷");
        divideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divideButtonActionPerformed(evt);
            }
        });

        equalsButton.setBackground(new java.awt.Color(153, 153, 153));
        equalsButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        equalsButton.setForeground(new java.awt.Color(0, 0, 0));
        equalsButton.setText("=");
        equalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(153, 153, 153));
        clearButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setText("C");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(backSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(divideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(subtractButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton0,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(decimalButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(equalsButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(divideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(subtractButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(decimalButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(equalsButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void setNewValues() {
        num1 = 0;
        num2 = 0;
        operator = "";
        error = false;
    }

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "0");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "1");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "2");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "3");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "4");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "5");
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "6");
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "7");
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "8");
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        jTextField1.setText(jTextField1.getText() + "9");
    }

    private void decimalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (error) {
            jTextField1.setText("");
            setNewValues();
        }
        if (!jTextField1.getText().contains(".")) {
            jTextField1.setText(jTextField1.getText() + ".");
        }
    }

    private void backSpaceActionPerformed(java.awt.event.ActionEvent evt) {
        String currentText = jTextField1.getText();

        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            jTextField1.setText(newText);
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (num1 == 0) {
            num1 = Double.parseDouble(jTextField1.getText());
        }
        operator = "+";
        jTextField1.setText("");
    }

    private void multiplyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (num1 == 0) {
            num1 = Double.parseDouble(jTextField1.getText());
        }
        operator = "*";
        jTextField1.setText("");
    }

    private void subtractButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (num1 == 0) {
            num1 = Double.parseDouble(jTextField1.getText());
        }
        operator = "-";
        jTextField1.setText("");
    }

    private void divideButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (num1 == 0) {
            num1 = Double.parseDouble(jTextField1.getText());
        }
        operator = "÷";
        jTextField1.setText("");
    }

    private void equalsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (operator != null) {
            num2 = Double.parseDouble(jTextField1.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "÷":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        jTextField1.setText("Syntax error.");
                        error = true;
                        return;
                    }
                    break;
                default:
                    error = true;
                    jTextField1.setText("Error");
                    break;
            }

            jTextField1.setText(String.valueOf(result));
            num1 = result;
            operator = "";
        } else if (num2 == 0) {
            num1 = Double.parseDouble(jTextField1.getText());
            jTextField1.setText(num1 + "");
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1.setText("");
        setNewValues();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private javax.swing.JButton addButton;
    private javax.swing.JButton backSpace;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton decimalButton;
    private javax.swing.JButton divideButton;
    private javax.swing.JButton equalsButton;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton multiplyButton;
    private javax.swing.JButton subtractButton;
}