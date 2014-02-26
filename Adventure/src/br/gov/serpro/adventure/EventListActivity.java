package br.gov.serpro.adventure;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class EventListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.event_list);
        
        PopulateListViewTask populateListViewTask = new PopulateListViewTask();
        populateListViewTask.execute();
        
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.event_list, menu);
        return true;
    }
	
	private class PopulateListViewTask extends AsyncTask<Void, Void, Event[]> {
		
		@Override
		protected Event[] doInBackground(Void... arg0) {

			AdventureService adventureService = new AdventureService();
			
			Event[] eventsList = adventureService.findAllEvents();
			
			return eventsList;
			
		}

		@Override
		protected void onPostExecute(Event[] events) {
			
			ListView eventListView = (ListView) EventListActivity.this.findViewById(R.id.eventsListView);
			
			EventListAdapter adapter = new EventListAdapter(EventListActivity.this, events);
			eventListView.setAdapter(adapter);
			
		}		
		
	}	
	
}
