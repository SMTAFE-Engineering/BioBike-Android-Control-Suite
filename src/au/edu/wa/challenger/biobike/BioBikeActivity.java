/*
 	This file is part of the BioBike Control App.
 
    The BioBike Control App is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The BioBike Control App is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with the BioBike Control App.  If not, see <http://www.gnu.org/licenses/>.
    
    Copyright 2012 Challenger Institute of Technology (http://www.challenger.wa.edu.au)
    
    Developed by Daniel Harmsworth (atrophy@caffeinator.net)
 */

package au.edu.wa.challenger.biobike;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.*;

public class BioBikeActivity extends Activity {
	public int hba_loc;
	Button			hba_btn_up;
	Button			hba_btn_down;
	EditText 		hba_loc_txt;
	SeekBar			hba_loc_skb;
	ToggleButton	hba_loc_ena;
	
	int hbl_loc = 50;
	Button			hbl_btn_up;
	Button			hbl_btn_down;
	EditText 		hbl_loc_txt;
	SeekBar			hbl_loc_skb;
	ToggleButton	hbl_loc_ena;
	
	int spa_loc = 50;
	Button			spa_btn_up;
	Button			spa_btn_down;
	EditText 		spa_loc_txt;
	SeekBar			spa_loc_skb;
	ToggleButton	spa_loc_ena;
	
	int spl_loc = 50;
	Button			spl_btn_up;
	Button			spl_btn_down;
	EditText 		spl_loc_txt;
	SeekBar			spl_loc_skb;
	ToggleButton	spl_loc_ena;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //This is where the ADK stuff should retrieve the current actuator positions.
        
        hba_loc_txt = (EditText) findViewById(R.id.txt_hba_pos);
        hba_loc_skb = (SeekBar) findViewById(R.id.skb_hba);
    	hba_loc_ena = (ToggleButton) findViewById(R.id.tog_hba_enable);
    	hba_btn_up = (Button) findViewById(R.id.btn_hba_up);
    	hba_btn_down = (Button) findViewById(R.id.btn_hba_down);
    	
    	hbl_loc_txt = (EditText) findViewById(R.id.txt_hbl_pos);
        hbl_loc_skb = (SeekBar) findViewById(R.id.skb_hbl);
    	hbl_loc_ena = (ToggleButton) findViewById(R.id.tog_hbl_enable);
    	hbl_btn_up = (Button) findViewById(R.id.btn_hbl_up);
    	hbl_btn_down = (Button) findViewById(R.id.btn_hbl_down);

    	spa_loc_txt = (EditText) findViewById(R.id.txt_spa_pos);
        spa_loc_skb = (SeekBar) findViewById(R.id.skb_spa);
    	spa_loc_ena = (ToggleButton) findViewById(R.id.tog_spa_enable);
    	spa_btn_up = (Button) findViewById(R.id.btn_spa_up);
    	spa_btn_down = (Button) findViewById(R.id.btn_spa_down);
    	
    	spl_loc_txt = (EditText) findViewById(R.id.txt_spl_pos);
        spl_loc_skb = (SeekBar) findViewById(R.id.skb_spl);
    	spl_loc_ena = (ToggleButton) findViewById(R.id.tog_spl_enable);
    	spl_btn_up = (Button) findViewById(R.id.btn_spl_up);
    	spl_btn_down = (Button) findViewById(R.id.btn_spl_down);

    	
    	set_hba(50);
    	set_hbl(50);
    	set_spa(50);
    	set_spl(50);
        
    	// Setting up the seekbar listeners
        hba_loc_skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { 
        	public void onProgressChanged(SeekBar seekbar_obj, int pos, boolean fromuser) {
        		if (fromuser) { set_hba(pos); }
            }
            public void onStartTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
            public void onStopTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
        } );
        
        hbl_loc_skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { 
        	public void onProgressChanged(SeekBar seekbar_obj, int pos, boolean fromuser) {
        		if (fromuser) { set_hbl(pos); }
            }
            public void onStartTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
            public void onStopTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
        } );
        
        spa_loc_skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { 
        	public void onProgressChanged(SeekBar seekbar_obj, int pos, boolean fromuser) {
        		if (fromuser) { set_spa(pos); }
            }
            public void onStartTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
            public void onStopTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
        } );
        
        spl_loc_skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { 
        	public void onProgressChanged(SeekBar seekbar_obj, int pos, boolean fromuser) {
        		if (fromuser) { set_spl(pos); }
            }
            public void onStartTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
            public void onStopTrackingTouch(SeekBar seekBar) { /*Nothing to see here*/ }
        } );
        
    }
    
    private void set_hba(int pos)
    {
    	if ((pos <= 100) && (pos >= 0))
    	{
    		hba_loc = pos;
    		hba_loc_txt.setText(Integer.toString(hba_loc));
    		hba_loc_skb.setProgress(hba_loc);
    	}
    	//ADK call to set the HBA actuator position goes here.
    }
    
    private void set_hbl(int pos)
    {
    	if ((pos <= 100) && (pos >= 0))
    	{
    		hbl_loc = pos;
    		hbl_loc_txt.setText(Integer.toString(hbl_loc));
    		hbl_loc_skb.setProgress(hbl_loc);
    	}
    	//ADK call to set the HBL actuator position goes here.
    }
    
    private void set_spa(int pos)
    {
    	if ((pos <= 100) && (pos >= 0))
    	{
    		spa_loc = pos;
    		spa_loc_txt.setText(Integer.toString(spa_loc));
    		spa_loc_skb.setProgress(spa_loc);
    	}
    	//ADK call to set the SPA actuator position goes here.
    }
    
    private void set_spl(int pos)
    {
    	if ((pos <= 100) && (pos >= 0))
    	{
    		spl_loc = pos;
    		spl_loc_txt.setText(Integer.toString(spl_loc));
    		spl_loc_skb.setProgress(spl_loc);
    	} 
    	//ADK call to set the SPL actuator position goes here.
    }

    // Button Handlers Ahoy!
    public void upClick_hba (View v){	set_hba(hba_loc + 1); }
    public void downClick_hba (View v){	set_hba(hba_loc - 1); }
    
    public void upClick_hbl (View v){	set_hbl(hbl_loc + 1); }
    public void downClick_hbl (View v){	set_hbl(hbl_loc - 1); }
    
    public void upClick_spa (View v){	set_spa(spa_loc + 1); }
    public void downClick_spa (View v){	set_spa(spa_loc - 1); }
    
    public void upClick_spl (View v){ 	set_spl(spl_loc + 1); }
    public void downClick_spl (View v){	set_spl(spl_loc - 1); }


}