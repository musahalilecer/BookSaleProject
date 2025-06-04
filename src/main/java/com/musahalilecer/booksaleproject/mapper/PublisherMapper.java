package com.musahalilecer.booksaleproject.mapper;

import com.musahalilecer.booksaleproject.dto.response.PublisherResponse;
import com.musahalilecer.booksaleproject.model.Publisher;

public class PublisherMapper {
    public static PublisherResponse toPublisherResponse(Publisher publisher) {
        return new PublisherResponse(
                publisher.getId(),
                publisher.getPublisherName(),
                publisher.getPublisherAddress(),
                publisher.getPublisherImage()
        );
    }
    public static Publisher toPublisherEntity(String publisherName, String publisherAddress, String publisherImage) {
        return Publisher.builder()
                .publisherName(publisherName)
                .publisherAddress(publisherAddress)
                .publisherImage(publisherImage)
                .build();
    }

}
