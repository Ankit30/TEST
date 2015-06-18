package com.mmx.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TempActivity extends Activity implements OnClickListener{
	
	private int[][] GridId = new int[4][4];
	
	private enum GridCode{
		BLANK, X, O
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temp);
		int id;
		Button button;
		for(int r=1;r<=3;r++){
			for(int c=1;c<=3;c++){
				id = getResources().getIdentifier("btnGrid" + r + c, "id", getPackageName());
				GridId[r][c] = id;
				button = (Button)findViewById(id);
				button.setText("");
				button.setOnClickListener(this);
			}
		}
		button = (Button) findViewById(R.id.btnReset);
	    button.setText("");
	    button.setOnClickListener(this);
	}
	

	private boolean gameHasEnded(){
		Button button = (Button)findViewById(R.id.btnReset);
		return button.getText() != "";
	}
	
	private void resetGrid(){
		Button button = (Button)findViewById(R.id.btnReset);
		button.setText("");
		for(int r=1;r<=3;r++){
			for(int c=1;c<=3;c++){
				button = (Button)findViewById(GridId[r][c]);
				button.setText("");
			}
		}
	}
	 
	
	@Override
	public void onClick(View v) {
		Button button = (Button) v;
		if(button == (Button)findViewById(R.id.btnReset)){
			if(gameHasEnded())
				resetGrid();
			return;
		}
		
		if(gameHasEnded() || button.getText() != "")
			return;
		
		button.setText("X");
		
		int xCountByRow[] = new int[4];
		int oCountByRow[] = new int[4];
		int xCountByColumn[] = new int[4];
		int oCountByColumn[] = new int[4];
		int xCountByDiagonal[] = new int[3];
		int oCountByDiagonal[] = new int[3];
		
		GridCode gc[][] = new GridCode[4][4];
		
		for(int r=1;r<=3;r++){
			for(int c=1;c<=3;c++){
				button = (Button) findViewById(GridId[r][c]);
				if(button.getText() == "X"){
					gc[r][c] = GridCode.X;
					xCountByRow[r]++;
					xCountByColumn[c]++;
					if(r == c)
						xCountByDiagonal[1]++;
					if(r + c == 4)
						xCountByDiagonal[2]++;
				} else if(button.getText() == "O") {
					gc[r][c] = GridCode.O;
					oCountByRow[r]++;
	                oCountByColumn[c]++;
				} else {
					gc[r][c] = GridCode.BLANK;
				}
			}
		}
		
		//Computer lost.
		for(int r=1;r<=3;r++){
			if(xCountByRow[r] == 3){
		//		declareLoss();
				return;
			}
		}
		for(int c=1;c<=3;c++){
			if(xCountByColumn[c] == 3){
		//		declareloss();
				return;
			}
		}
		for(int d=1;d<=2;d++){
			if(xCountByDiagonal[d] == 3){
		//		declareLoss();
				return;
			}
		}
		
		
		
		
		
	}

}
