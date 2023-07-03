import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GUI extends JFrame {

    public GUI(Graph Graph) {
        super("labyrinthe.java");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);

        Graph(Graph);
    }

    public JLabel imglabel(String path, int x, int y ) {
        JLabel temp = new JLabel(new ImageIcon(path));
        temp.setBounds(x,y, 64, 64);
        return temp;

    }

    public void Graph(Graph l){
        JPanel content = (JPanel) this.getContentPane();
        content.setLayout(null);
        for(Node i : l.nodes){
            if(l.contains(i, l.getNode(i.getx()+1, i.gety())) == false) {
                //System.out.println(i.getx() + " " +i.gety());
                content.add(imglabel("img/side.png", 64*i.getx()+30, 64*i.gety()));
            }
            if(l.contains(i, l.getNode(i.getx(), i.gety()+1)) == false) {
                //System.out.println(i.getx() + " " +i.gety());
                content.add(imglabel("img/up.png", 64*i.getx(), 64*i.gety()+30));
            }
            if(l.contains(i, l.getNode(i.getx()-1, i.gety())) == false) {
                //System.out.println(i.getx() + " " +i.gety());
                content.add(imglabel("img/side.png", 64*i.getx()-30, 64*i.gety()));
            }
            if(l.contains(i, l.getNode(i.getx(), i.gety()-1)) == false) {
                //System.out.println(i.getx() + " " +i.gety());
                content.add(imglabel("img/up.png", 64*i.getx(), 64*i.gety()-30));
            }

            content.add(imglabel("img/purple_font.jpg", 64*i.getx(), 64*i.gety()));
        }
        content.setPreferredSize(content.getPreferredSize());
    }
}