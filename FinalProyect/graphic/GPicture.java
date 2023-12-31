package graphic;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class GPicture extends Component {
	private Image pic;
	public GPicture(Image pic){
		this.pic = pic;
		int w = 0;
		int h = 0;
		for(String s: pic){
			w = Math.max(w, s.length());
			h++;
		}
		setSize(w, h);
	}
	
	@Override
	public void paint(Graphics g) {
		int y = 0;
		for(String s: pic){
			parseLine(g, y, s);
			y++;
		}
	}
	
	//Interpreta un String como una secuencia de lineas
	private void parseLine(Graphics g, int y, String s) {
		int xi = 0, xf = 1;
		char c = s.charAt(xi);
		
		while( xf < s.length()){
			if(c == ' '){
				c = s.charAt(xf);
				xi = xf;
			}else if (c != s.charAt(xf)){
				
				g.setColor(parserChar(c));
				g.drawLine(xi, y, xf, y);
				c = s.charAt(xf);
				xi = xf + 1;
			}
			xf++;
		}
		
		if(c != ' '){
			g.setColor(parserChar(c));
			g.drawLine(xi, y, xf, y);
		}
	}
	
	private Color parserChar(char c){
		Color col;
		switch (c) {
		case '_': col = Color.LIGHT_GRAY; break;
		case '=': col = Color.DARK_GRAY; break;
		case '.': col = Color.WHITE; break;
		case ':': col = Color.CYAN; break;
		case '*': col = Color.GREEN; break;
		case '#': col = Color.RED; break;
		case '&': col = Color.BLUE; break;
		default: col = Color.BLACK; break;
		}
		return col;
	}
	
}