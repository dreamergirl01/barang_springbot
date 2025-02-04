package barang_springboot.barang.repository;

import barang_springboot.barang.entity.BarangEntity;
import barang_springboot.barang.entity.QBarangEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class BarangCustomRepositoryImpl implements BarangCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);



    @Override
    public List<BarangEntity> findAllWithFilters(String namaBarang, Integer jumlahStok, String sortBy, String sortDirection) {
        var barang = new QBarangEntity("k");

        BooleanExpression predicate = barang.isNotNull();

        if (namaBarang != null && !namaBarang.isEmpty()) {
            predicate = predicate.and(barang.namaBarang.containsIgnoreCase(namaBarang));
        }
        if (jumlahStok != null){
            predicate = predicate.and(barang.jumlahStok.eq(jumlahStok));
        }

        return queryFactory.selectFrom(barang)
                .where(predicate)
                .orderBy(sortDirection.equalsIgnoreCase("desc") ? barang.namaBarang.desc() : barang.namaBarang.asc())
                .fetch();
    }
}