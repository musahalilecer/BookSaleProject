package com.musahalilecer.booksaleproject.service.serviceImp;

import com.musahalilecer.booksaleproject.dto.request.PublisherRequest;
import com.musahalilecer.booksaleproject.dto.response.PublisherResponse;
import com.musahalilecer.booksaleproject.mapper.PublisherMapper;
import com.musahalilecer.booksaleproject.model.Publisher;
import com.musahalilecer.booksaleproject.repository.PublisherRepository;
import com.musahalilecer.booksaleproject.service.services.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImp implements PublishService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<PublisherResponse> getPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream().map(PublisherMapper::toPublisherResponse).collect(Collectors.toList());
    }

    @Override
    public PublisherResponse getPublisher(Integer id) {
        return publisherRepository.findById(id)
                .map(PublisherMapper::toPublisherResponse)
                .orElseThrow(() -> new RuntimeException());
    }
    /*
    return authorRepository.findById(id)
                .map(AuthorMapper::toAuthorResponse)
                .orElseThrow(() -> new AuthorNotFoundException("Author not Found"));
     */

    @Override
    public PublisherResponse createPublisher(PublisherRequest publisher) {

        Publisher newPublisher = PublisherMapper.toPublisherEntity(publisher.getPublisherName(),  publisher.getPublisherAddress(), publisher.getPublisherImage());
        Publisher savedPublisher = publisherRepository.save(newPublisher);
        return PublisherMapper.toPublisherResponse(savedPublisher);
    }

    @Override
    public PublisherRequest updatePublisher(Publisher publisher) {
        return null;
    }

    @Override
    public void deletePublisher(Integer id) {
    publisherRepository.deleteById(id);
    }
}
