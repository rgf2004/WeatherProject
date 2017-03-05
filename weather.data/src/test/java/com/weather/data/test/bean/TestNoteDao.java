package com.weather.data.test.bean;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weather.core.exception.WeatherException;
import com.weather.data.dao.NoteDao;
import com.weather.data.enums.PreDefinedNoteRangeEnum;
import com.weather.data.model.Note;
import com.weather.data.model.PredefinedNote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@Transactional
public class TestNoteDao {

	@Autowired
	NoteDao noteDao;
	
	@Test
	@Rollback
	public void testAddNewNote() throws WeatherException
	{
		String noteBody = "This is a test note";
		
		Note note = new Note();
		note.setNoteBody(noteBody);
		
		noteDao.createNote(note);
	
	}
	
	@Test
	@Rollback
	public void testAddNewPredefinedNote() throws WeatherException
	{
		String noteBody = "This is a test predifned note";
		int fromDegree = 1;
		int toDegree = 10;
		PreDefinedNoteRangeEnum range = PreDefinedNoteRangeEnum.PREDIFNED_NOTE_RANGE_3;
		
		PredefinedNote note = new PredefinedNote();		
		note.setNoteBody(noteBody);
		note.setFromDegree(fromDegree);
		note.setToDegree(toDegree);
		note.setNoteRange(range);
		
		noteDao.createPredefinedNote(2,note);
	
	}
	
}

