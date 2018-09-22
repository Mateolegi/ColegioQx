package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;
import co.com.quipux.ColegioQuipux.presentacion.util.Colores;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.lang.InstantiationException;
/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Contenedor extends JPanel{
    private Control_Instancias pp;
    /*JPANELES*/
    private JPanel MenuP = new JPanel();
    private JPanel Contenido = new JPanel();
    private JPanel ultJPanel;
    /*Tamaños*/
    protected int frameSize[] = new int[2];
    private int DimencionesActual_x;
    private int DimencionesActual_y;
    /*Control del Menu*/
    private boolean controlMenu = false;
    
    public Contenedor(int width, int height, Control_Instancias a){
        frameSize[0] = width;
        frameSize[1] = height;
        DimencionesActual_x = width;
        DimencionesActual_y = height;
        this.pp = a;
        
        MenuP.add(new Menu(a,width,height));
        add(MenuP);
        
        Contenido.setLayout(new FlowLayout(FlowLayout.LEFT,0,0)); 
        Contenido.add(ultJPanel = new Pnl_preLogin(pp, width, height));
        //Contenido.add(ultJPanel.add(barra));
        add(Contenido);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.BLACK);
        
        MenuP.setBounds(0, 0, frameSize[0] / 4, frameSize[1]);
        MenuP.setBackground(Colores.pantone276C);
        MenuP.setSize(frameSize[0] / 4, frameSize[1]);
        MenuP.setFocusable(false);
        MenuP.setVisible(controlMenu);
        
        Contenido.setBounds((controlMenu)? MenuP.getWidth():0, 0, frameSize[0], frameSize[1]);
        Contenido.setSize(DimencionesActual_x, frameSize[1]);
        Contenido.setBackground(Color.white);
        Contenido.setFocusable(false);
        //Contenido.setDoubleBuffered(true);
    }
    
    public void validarInicioDeSeccion() {
        controlMenu = true;
        DimencionesActual_x = frameSize[0]+frameSize[1];
        setPantallasPrincipales(0);
    }
    
    public void ValidarCerrarSeccion(){
        controlMenu = false;
        DimencionesActual_x = frameSize[0];
        DimencionesActual_y= frameSize[1];
        Pnl_login.tipoUsuario="";
        setPantallaLogin(0);
    }
    
    public void setPantallaLogin(int Index){
        Contenido.remove(ultJPanel);
        
        switch (Index) {
            case 0:
                Contenido.add(ultJPanel =new Pnl_preLogin(pp,frameSize[0], frameSize[1]));
                break;
            case 1:
                Contenido.add(ultJPanel =new Pnl_login(pp,frameSize[0], frameSize[1]));
                break;
                
            default:
                throw new IndexOutOfBoundsException("El indice ingresado no se encuentra declarado");
        }
        Contenido.updateUI();
        Contenido.repaint();
    }
    
    /**
     * Maneja la instancia del contenido
     * @param Index Indece de la pantalla que se va a mostrar
     */
    public void setPantallasPrincipales(int Index){
        Contenido.remove(ultJPanel);
        
        switch (Index) {
            case 0:
                Contenido.add(ultJPanel = new Pnl_inicio(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
                
            case 1:
                Contenido.add(ultJPanel= new Pnl_registros(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
                
            case 2:
                Contenido.add(ultJPanel= new Pnl_planillas(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 3:
                Contenido.add(ultJPanel= new Pnl_perfil(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 4:
                Contenido.add(ultJPanel= new Pnl_consultar(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
             
            
            default:
                throw new IndexOutOfBoundsException("El indice ingresado no se encuentra declarado");
        }
        Contenido.updateUI();
        Contenido.repaint();
    }
    
    public void setPantallasRegistro(int Index){
        Contenido.remove(ultJPanel);
        
        switch (Index) {
            case 0:/*Registrar estudiantes*/
                Contenido.add(ultJPanel = new Pnl_registrosEstudiante(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 1:/*Registrar profesores*/
                Contenido.add(ultJPanel = new Pnl_registrosProfesor(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 2:/*Registrar administradores*/
                Contenido.add(ultJPanel = new Pnl_registrosAdministrador(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 3:/*Registrar materias*/
                Contenido.add(ultJPanel = new Pnl_registrosMaterias(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 4:/*Registrar Grupos*/
                Contenido.add(ultJPanel = new Pnl_registrosGrupos(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            
            default:
                throw new IndexOutOfBoundsException("El indice ingresado no se encuentra declarado");
        }
        Contenido.updateUI();
        Contenido.repaint();
    }
    
    public void setPantallasConsultar(int Index){
        Contenido.remove(ultJPanel);
        
        switch (Index) {
            case 0:/*Consultar Profesor*/
                Contenido.add(ultJPanel = new Pnl_consultarProfesor(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
                
            case 1:/*Consultar Grado materia*/
                Contenido.add(ultJPanel = new Pnl_consultarGradoMateria(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;
            case 2:/*Consultar Grupo*/
                Contenido.add(ultJPanel = new Pnl_consultarGrupo(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;    
                
            case 3:/*Consultar Grupo*/
                Contenido.add(ultJPanel = new Pnl_consultarProfesor_Materia_Grupo(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;    
                
            case 4:/*Consultar GradosCursados*/
                Contenido.add(ultJPanel = new Pnl_consultarGradosCursados(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break; 
                
            case 5:/*Consultar Notas Estudiante*/
                Contenido.add(ultJPanel = new Pnl_consultarEstudiante_Notas(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break; 
            case 6:/*Consultar Notas Estudiante*/
                Contenido.add(ultJPanel = new Pnl_consultarEstudiante(pp,frameSize[0]-MenuP.getWidth(), frameSize[1]));
                break;     
            
                
            
            default:
                throw new IndexOutOfBoundsException("El indice ingresado no se encuentra declarado");
        }
        Contenido.updateUI();
        Contenido.repaint();
    }
    
    /**
     * Maneja la instancia del contenido
     * @param Nombre_Pantalla Nombre de la pantalla que se debe cargar
     */
    public void controlPantallas(String Nombre_Pantalla){
        Contenido.removeAll();
    }
}
