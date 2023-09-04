package bitcamp.myapp.dao;

import java.util.List;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import org.apache.ibatis.annotations.Param;

public interface BoardDao {
  int insert(Board board);
  List<Board> findAll(int category);
  Board findBy(@Param("categoryNo") int category);
  int update(Board board);
  int updateCount(int board);
  int delete(int board);

  int insertFiles(Board board);
  AttachedFile findFileBy(int no);
  int deleteFile(int fileNo);

  int deleteFiles(int boardNo);
}
