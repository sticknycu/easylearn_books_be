package ro.nicolaemariusghergu.easylearn.books.mapper;

import javax.annotation.processing.Generated;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.AuthorDTO.AuthorDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.BookDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.BookDTO.BookDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.CategoryDTO.CategoryDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.DiscountDTO.DiscountDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.PriceTypeDTO.PriceTypeDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO.PublishHouseDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO.StatusDTOBuilder;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Author;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Book;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Category;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Discount;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PriceType;
import ro.nicolaemariusghergu.easylearn.books.model.entities.PublishHouse;
import ro.nicolaemariusghergu.easylearn.books.model.entities.Status;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-26T17:14:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (GraalVM Community)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTOBuilder<?, ?> bookDTO = BookDTO.builder();

        bookDTO.id( book.getId() );
        bookDTO.title( book.getTitle() );
        bookDTO.category( categoryToCategoryDTO( book.getCategory() ) );
        bookDTO.status( statusToStatusDTO( book.getStatus() ) );
        bookDTO.discount( discountToDiscountDTO( book.getDiscount() ) );
        bookDTO.priceType( priceTypeToPriceTypeDTO( book.getPriceType() ) );
        bookDTO.publishHouse( publishHouseToPublishHouseDTO( book.getPublishHouse() ) );
        bookDTO.stockCount( book.getStockCount() );
        bookDTO.author( authorToAuthorDTO( book.getAuthor() ) );
        bookDTO.iconUrl( book.getIconUrl() );
        bookDTO.price( book.getPrice() );

        return bookDTO.build();
    }

    @Override
    public Book bookDtoToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setCategory( categoryDTOToCategory( bookDTO.getCategory() ) );
        book.setStatus( statusDTOToStatus( bookDTO.getStatus() ) );
        book.setDiscount( discountDTOToDiscount( bookDTO.getDiscount() ) );
        book.setPriceType( priceTypeDTOToPriceType( bookDTO.getPriceType() ) );
        book.setPublishHouse( publishHouseDTOToPublishHouse( bookDTO.getPublishHouse() ) );
        book.setStockCount( bookDTO.getStockCount() );
        book.setIconUrl( bookDTO.getIconUrl() );
        book.setPrice( bookDTO.getPrice() );
        book.setTitle( bookDTO.getTitle() );
        book.setAuthor( authorDTOToAuthor( bookDTO.getAuthor() ) );

        return book;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTOBuilder<?, ?> categoryDTO = CategoryDTO.builder();

        categoryDTO.id( category.getId() );
        categoryDTO.name( category.getName() );

        return categoryDTO.build();
    }

    protected StatusDTO statusToStatusDTO(Status status) {
        if ( status == null ) {
            return null;
        }

        StatusDTOBuilder<?, ?> statusDTO = StatusDTO.builder();

        statusDTO.id( status.getId() );
        statusDTO.statusType( status.getStatusType() );

        return statusDTO.build();
    }

    protected DiscountDTO discountToDiscountDTO(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        DiscountDTOBuilder<?, ?> discountDTO = DiscountDTO.builder();

        discountDTO.id( discount.getId() );
        discountDTO.value( discount.getValue() );

        return discountDTO.build();
    }

    protected PriceTypeDTO priceTypeToPriceTypeDTO(PriceType priceType) {
        if ( priceType == null ) {
            return null;
        }

        PriceTypeDTOBuilder<?, ?> priceTypeDTO = PriceTypeDTO.builder();

        priceTypeDTO.id( priceType.getId() );
        priceTypeDTO.value( priceType.getValue() );

        return priceTypeDTO.build();
    }

    protected PublishHouseDTO publishHouseToPublishHouseDTO(PublishHouse publishHouse) {
        if ( publishHouse == null ) {
            return null;
        }

        PublishHouseDTOBuilder<?, ?> publishHouseDTO = PublishHouseDTO.builder();

        publishHouseDTO.id( publishHouse.getId() );
        publishHouseDTO.name( publishHouse.getName() );

        return publishHouseDTO.build();
    }

    protected AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTOBuilder<?, ?> authorDTO = AuthorDTO.builder();

        authorDTO.id( author.getId() );
        authorDTO.name( author.getName() );

        return authorDTO.build();
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    protected Status statusDTOToStatus(StatusDTO statusDTO) {
        if ( statusDTO == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( statusDTO.getId() );
        status.setStatusType( statusDTO.getStatusType() );

        return status;
    }

    protected Discount discountDTOToDiscount(DiscountDTO discountDTO) {
        if ( discountDTO == null ) {
            return null;
        }

        Discount discount = new Discount();

        discount.setId( discountDTO.getId() );
        discount.setValue( discountDTO.getValue() );

        return discount;
    }

    protected PriceType priceTypeDTOToPriceType(PriceTypeDTO priceTypeDTO) {
        if ( priceTypeDTO == null ) {
            return null;
        }

        PriceType priceType = new PriceType();

        priceType.setId( priceTypeDTO.getId() );
        priceType.setValue( priceTypeDTO.getValue() );

        return priceType;
    }

    protected PublishHouse publishHouseDTOToPublishHouse(PublishHouseDTO publishHouseDTO) {
        if ( publishHouseDTO == null ) {
            return null;
        }

        PublishHouse publishHouse = new PublishHouse();

        publishHouse.setId( publishHouseDTO.getId() );
        publishHouse.setName( publishHouseDTO.getName() );

        return publishHouse;
    }

    protected Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setName( authorDTO.getName() );

        return author;
    }
}
