package edu.berkeley.cs160.clairetuna.prog1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "edu.berkeley.cs160.clairetuna.prog1";
	EditText cost;
	int decimalIndex;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		// Capture button from layout
               
		Button button0 = (Button)findViewById(R.id.button0);
		Button button1 = (Button)findViewById(R.id.button1);
		Button button2 = (Button)findViewById(R.id.button2);
		Button button3 = (Button)findViewById(R.id.button3);
		Button button4 = (Button)findViewById(R.id.button4);
		Button button5 = (Button)findViewById(R.id.button5);
		Button button6 = (Button)findViewById(R.id.button6);
		Button button7 = (Button)findViewById(R.id.button7);
		Button button8 = (Button)findViewById(R.id.button8);
		Button button9 = (Button)findViewById(R.id.button9);
		Button deleteButton = (Button)findViewById(R.id.buttonDelete);
		Button tipButton = (Button)findViewById(R.id.buttonCalculate);
		button0.setOnClickListener(button0Listener);
		button1.setOnClickListener(button1Listener);
		button2.setOnClickListener(button2Listener);
		button3.setOnClickListener(button3Listener);
		button4.setOnClickListener(button4Listener);
		button5.setOnClickListener(button5Listener);
		button6.setOnClickListener(button6Listener);
		button7.setOnClickListener(button7Listener);
		button8.setOnClickListener(button8Listener);
		button9.setOnClickListener(button9Listener);
		deleteButton.setOnClickListener(deleteListener);
		tipButton.setOnClickListener(tipCalculateListener);
		cost = (EditText)findViewById(R.id.cost);
		cost.setText("$.00");
		decimalIndex=1;
	}
	
	public void addText(String newText){
		String currentCost = cost.getText().toString();
		decimalIndex=currentCost.indexOf(".");
		//String currentCost = cost.getText().toString();
		
		//concatenate new number to tail
		currentCost=currentCost+newText;
		
		//remove decimal
		currentCost=currentCost.substring(0, decimalIndex)+currentCost.substring(decimalIndex+1, currentCost.length());
		decimalIndex++;
		currentCost=currentCost.substring(0, decimalIndex)+ "."+ currentCost.substring(decimalIndex, currentCost.length());
		//delete leading 0
		if (currentCost.contains("$0.")){

			currentCost="$"+currentCost.substring(2, currentCost.length());
		}
		cost.setText(currentCost);
	}
	
	public void removeText(){
		String currentCost = cost.getText().toString();
		decimalIndex=currentCost.indexOf(".");
		//remove from tail
		currentCost=currentCost.substring(0, currentCost.length()-1);
		System.out.println("currentCost 1 is : "+ currentCost);
		//if we need to add back a 0
		if (currentCost.substring(0, decimalIndex).equals("$")){
			System.out.println("currentCost 2 is : "+ currentCost);
			currentCost="$.0"+currentCost.substring(currentCost.length()-1, currentCost.length());

		}
		else{
		//remove decimal
		currentCost=currentCost.substring(0, decimalIndex)+currentCost.substring(decimalIndex+1, currentCost.length());
		decimalIndex--;
		//put decimal back
		currentCost=currentCost.substring(0, decimalIndex)+ "."+ currentCost.substring(decimalIndex, currentCost.length());
		}
		
		cost.setText(currentCost);
	}

	
	View.OnClickListener button0Listener = new View.OnClickListener(){
		public void onClick(View v){
	      	addText("0");
		}
	};
	
	
	
	
	View.OnClickListener button1Listener = new View.OnClickListener(){
		public void onClick(View v){
			System.out.println("here here help");
			addText("1");
		}
	};
	View.OnClickListener button2Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("2");
		}
	};
	View.OnClickListener button3Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("3");
		}
	};
	View.OnClickListener button4Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("4");
		}
	};
	View.OnClickListener button5Listener = new View.OnClickListener(){
		public void onClick(View v){
		addText("5");
	}
	};
	View.OnClickListener button6Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("6");
		}
	};
	View.OnClickListener button7Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("7");
		}
	};
	View.OnClickListener button8Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("8");
		}
	};
	View.OnClickListener button9Listener = new View.OnClickListener(){
		public void onClick(View v){
			addText("9");
		}
	};
	View.OnClickListener deleteListener = new View.OnClickListener(){
		public void onClick(View v){
			removeText();
			
		}
	};
	View.OnClickListener tipCalculateListener = new View.OnClickListener(){
		public void onClick(View v){
			EditText cost = (EditText)findViewById(R.id.cost);
			String costString = cost.getText().toString();
			if (costString.length()>0){
				Intent intent = new Intent(MainActivity.this, DisplayTipActivity.class);
				intent.putExtra("COST_OF_DINNER_MESSAGE", costString);
				startActivity(intent);
			}
		}
	};
	
	

	   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
 
    
    /** Called when the user clicks the calculate button */

    
}
