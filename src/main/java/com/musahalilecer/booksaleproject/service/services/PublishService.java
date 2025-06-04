package com.musahalilecer.booksaleproject.service.services;

import com.musahalilecer.booksaleproject.dto.request.PublisherRequest;
import com.musahalilecer.booksaleproject.dto.response.PublisherResponse;
import com.musahalilecer.booksaleproject.model.Publisher;

import java.util.List;

public interface PublishService {
    List<PublisherResponse> getPublishers();
    PublisherResponse getPublisher(Integer id);
    PublisherResponse createPublisher(PublisherRequest publisherRequest);
    PublisherRequest updatePublisher(Publisher publisher);
    void deletePublisher(Integer id);
}
