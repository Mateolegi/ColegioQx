package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;
import co.com.quipux.ColegioQuipux.models.entity.EstudianteEntity;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JEditorPaneArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Pnl_registros extends JPanel implements ActionListener{
    protected Control_Instancias pp;
    protected int width, heigth;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_estudiante,lbl_profesor,lbl_administrador,lbl_notas,
            lbl_materias,lbl_grupos,lbl_planEvaluacion;
    /*JEditor Pane*/
    private JEditorPaneArje txt_informacion;
    /*JButtonArje*/
    private JButtonArje btn_estudiante,btn_profesor,btn_administrador,btn_notas,
            btn_materias,btn_grupos;
    
    boolean profesor,administrador;
    
    
    public Pnl_registros(Control_Instancias instancias,int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pp=instancias;
        
        lbl_titulo =  new JLabelArje();
            lbl_titulo.setTexto("Sección: Registros", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        lbl_estudiante =  new JLabelArje();
            lbl_estudiante.setTexto("Estudiante: ", Fonts.Lato, 1, 14, Colores.pantone1645C, 0);
            this.add(lbl_estudiante);
            
        lbl_profesor =  new JLabelArje();
            lbl_profesor.setTexto("Profesor: ", Fonts.Lato, 1, 14, Colores.pantone1645C, 0);
            this.add(lbl_profesor);
            
        lbl_administrador =  new JLabelArje();
            lbl_administrador.setTexto("Administrador: ", Fonts.Lato, 1, 14, Colores.pantone1645C, 0);
            this.add(lbl_administrador);
            
        lbl_notas =  new JLabelArje();
            lbl_notas.setTexto("Notas: ", Fonts.Lato, 1, 14, Colores.pantone1645C, 0);
            this.add(lbl_notas);
            
        lbl_materias =  new JLabelArje();
            lbl_materias.setTexto("Materias: ", Fonts.Lato, 1, 14, Colores.pantone1645C, 0);
            this.add(lbl_materias);
            
        lbl_grupos =  new JLabelArje();
            lbl_grupos.setTexto("Grupos: ", Fonts.Lato, 1, 14, Colores.pantone1645C, 0);
            this.add(lbl_grupos);
        
        txt_informacion = new JEditorPaneArje();
            txt_informacion.setTexto(Fonts.txt_inicio+"<b>¿Que deseas registrar?</b>"+Fonts.txt_final);
            this.add(txt_informacion);
            
        btn_estudiante=new JButtonArje("Estudiante",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_estudiante.addActionListener(this);
            this.add(btn_estudiante);
            
        btn_profesor=new JButtonArje("Profesor",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_profesor.addActionListener(this);
            this.add(btn_profesor);
            
        btn_administrador=new JButtonArje("Administrador",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_administrador.addActionListener(this);
            this.add(btn_administrador);
            
        btn_notas=new JButtonArje("Notas",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_notas.addActionListener(this);
            this.add(btn_notas);
            
        btn_materias=new JButtonArje("Materias",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_materias.addActionListener(this);
            this.add(btn_materias);
            
        btn_grupos=new JButtonArje("Grupos",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_grupos.addActionListener(this);
            this.add(btn_grupos);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.blanco);
        setSize(width,heigth);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        
        txt_informacion.setBounds(10, 50, 500, 25);
        if(Pnl_login.tipoUsuario.equals("Profesor")){
            administrador=false;
            profesor=true;
            
            lbl_notas.setBounds((width-150)/2, 100-25, 500, 25);
            btn_notas.setBounds((width-150)/2, 100, 150, 25);
        }else{
            administrador=true;
            profesor=false;
            
            lbl_estudiante.setBounds((width-150)/2, 100-25, 500, 25);
            btn_estudiante.setBounds((width-150)/2, 100, 150, 25);
            lbl_profesor.setBounds((width-150)/2, btn_estudiante.getY()+60-25, 500, 25);
            btn_profesor.setBounds((width-150)/2, btn_estudiante.getY()+60, 150, 25);
            lbl_materias.setBounds((width-150)/2, btn_profesor.getY()+60-25, 500, 25);
            btn_materias.setBounds((width-150)/2, btn_profesor.getY()+60, 150, 25);
            lbl_notas.setBounds((width-150)/2, btn_materias.getY()+60-25, 500, 25);
            btn_notas.setBounds((width-150)/2, btn_materias.getY()+60, 150, 25);
            lbl_grupos.setBounds((width-150)/2, btn_materias.getY()+60-25, 500, 25);
            btn_grupos.setBounds((width-150)/2, btn_materias.getY()+60, 150, 25);
            
            lbl_administrador.setBounds((width-150)/2, btn_profesor.getY()+60-25, 500, 25);
            btn_administrador.setBounds((width-150)/2, btn_profesor.getY()+60, 150, 25);
            
            
        }
        
        lbl_estudiante.setVisible(administrador);
        btn_estudiante.setVisible(administrador);
        lbl_profesor.setVisible(administrador);
        btn_profesor.setVisible(administrador);
        lbl_administrador.setVisible(false);
        btn_administrador.setVisible(false);
        lbl_materias.setVisible(administrador);
        btn_materias.setVisible(administrador);
        lbl_grupos.setVisible(administrador);
        btn_grupos.setVisible(administrador);
        
        lbl_notas.setVisible(profesor);
        btn_notas.setVisible(profesor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_estudiante){
            pp.getContenedor().setPantallasRegistro(0);
        }
        if(e.getSource()==btn_profesor){
            pp.getContenedor().setPantallasRegistro(1);
        }
        if(e.getSource()==btn_administrador){
            pp.getContenedor().setPantallasRegistro(2);
        }
        if(e.getSource()==btn_materias){
            pp.getContenedor().setPantallasRegistro(3);
        }
        if(e.getSource()==btn_grupos){
            pp.getContenedor().setPantallasRegistro(4);
        }
        
    }
}
