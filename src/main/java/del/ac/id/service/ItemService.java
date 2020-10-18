package del.ac.id.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.ItemRepository;


@Service
public class ItemService {

	@Autowired ItemRepository itemRepository;
	
	
}
